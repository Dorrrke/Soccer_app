package com.example.soccer_application.domain.models

data class Response(
	val data: List<DataItem?>? = null,
	val meta: Meta? = null
)

data class Meta(
	val msg: Any? = null,
	val total: Int? = null,
	val pages: Int? = null,
	val requestsLeft: Int? = null,
	val count: Int? = null,
	val page: Int? = null,
	val user: String? = null,
	val plan: String? = null
)

data class DataItem(
	val id: String? = null,
	val name: String? = null,
	val isCup: String? = null,
	val isAmateur: String? = null,
	val isFriendly: String? = null,
	val continentId: String? = null,
	val continentName: String? = null,
	val countryId: String? = null,
	val countryName: String? = null,
	val cc: String? = null,
	val currentSeasonId: String? = null,
	val currentRoundId: String? = null,
	val currentStageId: Any? = null







)

