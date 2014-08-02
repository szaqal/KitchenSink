package com.szaqal.spray


object SprayApp extends App {
  SprayDownload.download("https://www.googleapis.com/youtube/v3/channels?part=contentDetails&mine=true")
}