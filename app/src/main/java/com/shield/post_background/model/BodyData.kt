package com.shield.post_background.model
import com.google.gson.annotations.SerializedName

data class BodyData(

	@field:SerializedName("node_id_")
	val nodeId: String? = null,

	@field:SerializedName("network_speed_")
	val networkSpeed: Long? = null,

	@field:SerializedName("battery_status")
	val batteryStatus: Long? = null,

	@field:SerializedName("free_bytes")
	val freeBytes: Long? = null,

	@field:SerializedName("used_bandwidth")
	val usedBandwidth: Long? = null,

	@field:SerializedName("last_chunk_download_time")
	val lastChunkDownloadTime: String? = null


)

