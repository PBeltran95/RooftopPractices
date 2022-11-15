package com.example.permissionrequestexample.view.retrofit.pokemodel

data class GenerationResponse(
    val count: Int? = null,
    val next: String? = null,
    val results: List<Pokemon>? = null
)