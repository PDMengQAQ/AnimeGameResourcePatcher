package org.anime_game_servers.gc_resource_patcher.patchers.quests.patched

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import org.anime_game_servers.gc_resource_patcher.patchers.quests.shared.GainItem
import org.anime_game_servers.gc_resource_patcher.patchers.quests.shared.QuestCondition
import org.anime_game_servers.gc_resource_patcher.patchers.quests.shared.QuestExec

@Serializable
data class PatchedQuest(
    val mainId: Int,
    val series: Int? = -1,
    val type: String? = null,

    val luaPath: String? = null,
    val repeatable: Boolean? = null,
    val suggestTrackOutOfOrder: Boolean? = null,
    val suggestTrackMainQuestList: List<Int>? = null,
    val rewardIdList: List<Int>? = null,
    val subQuests: List<PatchSubQuest>? = null,
    val talks: List<TalkDataBinout>? = null,


    // Textmaps
    val titleTextMapHash: Long = -1,
    val descTextMapHash: Long = -1,

    ) {

    @Serializable
    data class PatchSubQuest(
        val subId: Int,
        val mainId: Int = -1,
        val order: Int = -1,
        val showType: String? = null,
        val finishParent: Boolean? = null,
        val isRewind: Boolean? = null,

        val luaPath: String? = null,
        val repeatable: Boolean? = null,
        val suggestTrackOutOfOrder: Boolean? = null,

        val versionBegin: String? = null,
        val versionEnd: String? = null,

        // quest conditions
        val acceptCondComb: String? = null,
        val acceptCond: List<QuestCondition>? = null,
        val finishCondComb: String? = null,
        val finishCond: List<QuestCondition>? = null,
        val failCondComb: String? = null,
        val failCond: List<QuestCondition>? = null,


        // quest execs
        val beginExec: List<QuestExec>? = null,
        val finishExec: List<QuestExec>? = null,
        val failExec: List<QuestExec>? = null,

        val gainItems: List<GainItem>? = null,


        // Textmaps
        val descTextMapHash: Long = -1,
        val stepDescTextMapHash: Long = -1,
    )

    @Serializable
    data class TalkDataBinout(
        val id: Int,
        val heroTalk: String? = null,
        val beginWay: String? = null,
        val beginCond: List<TalkBeginCond>? = null,
        val priority: Int = -1,
        val initDialog: Int = -1,
        val npcIds: List<Int>? = null,
        val performCfg: String? = null,
        val questId: Int = -1,
        val prePerformCfg: String? = null,
    )

    @OptIn(ExperimentalSerializationApi::class)
    @Serializable
    data class TalkBeginCond(
        @JsonNames("type", "_type")
        val type: String? = null,
        @JsonNames("params", "_params")
        val params: List<String>? = null
    )
}