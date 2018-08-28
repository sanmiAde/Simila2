package com.adetech.simila2.data.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Artist(
        @SerializedName("name") @Expose val name: String?,
        @SerializedName("mbid") @Expose val bid: String?,
        @SerializedName("match") @Expose val match: String?,
        @SerializedName("url") @Expose val url: String?,
        @SerializedName("image") @Expose val image: List<Image>?,
        @SerializedName("streamable") @Expose val streamable: String?)


class ArtistList(@SerializedName("artist") @Expose val artist: List<Artist>?)


class Image(
        @SerializedName("#text") @Expose val text: String?,
        @SerializedName("size")
        @Expose
        val size: String?)


class SimilarArtist(@SerializedName("similarartists") @Expose val similarartists: ArtistList?)



