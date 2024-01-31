package com.shield.post_background.model
import com.google.gson.annotations.SerializedName

data class ResponseData(

	@field:SerializedName("store_chunk_id_")
	val storeChunkId: String? = null,

	@field:SerializedName("access_chunk_id")
	val accessChunkId: String? = null,

	@field:SerializedName("store_chunk_fb_link")
	val storeChunkFbLink: String? = null,

	@field:SerializedName("access_chunk_status")
	val accessChunkStatus: Boolean? = null,

	@field:SerializedName("store_chunk_status")
	val storeChunkStatus: Boolean? = null
)

