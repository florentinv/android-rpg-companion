package com.fvanaldewereld.rpgcompanion.scenario.business.domain.mapper

import com.fvanaldewereld.rpgcompanion.common.mapper.Mapper
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.ScenarioModel
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.TextType
import com.fvanaldewereld.rpgcompanion.scenario.business.domain.model.TreeModel
import com.google.api.services.docs.v1.model.Document

interface ScenarioModelMapper : Mapper<Document, ScenarioModel>
class ScenarioModelMapperImpl : ScenarioModelMapper {
    override fun to(from: Document) = ScenarioModel(
        documentName = from.title,
        tree = getTree(from),
    )

    private fun getTree(from: Document): TreeModel {
        val tree = TreeModel(
            content = "",
            children = mutableListOf(),
            type = TextType.TITLE,
        )
        from.body.content.forEach { structuralElement ->
            when (structuralElement?.paragraph?.paragraphStyle?.namedStyleType) {
                TextType.TITLE.name -> {
                    var paragraphText = ""
                    structuralElement.paragraph.elements.forEach { element ->
                        element?.textRun?.content?.let { text -> paragraphText += text }
                    }
                    tree.content = paragraphText
                }

                TextType.HEADING_1.name -> {
                    var paragraphText = ""
                    structuralElement.paragraph.elements.forEach { element ->
                        element?.textRun?.content?.let { text -> paragraphText += text }
                    }

                    if (paragraphText.isNotBlank()) {
                        val childTree = TreeModel(
                            content = paragraphText,
                            type = TextType.HEADING_1,
                        )
                        tree.children.add(childTree)
                    }
                }

                TextType.NORMAL_TEXT.name -> {
                    var paragraphText = ""
                    structuralElement.paragraph.elements.forEach { element ->
                        element?.textRun?.content?.let { text -> paragraphText += text }
                    }

                    if (tree.children.isNotEmpty()) {
                        val parentTree = tree.children.last()

                        if (paragraphText.isNotBlank()) {
                            val childTree = TreeModel(
                                content = paragraphText,
                                type = TextType.NORMAL_TEXT,
                            )
                            parentTree.children.add(childTree)
                        }
                    }
                }
            }
        }
        return tree
    }

}