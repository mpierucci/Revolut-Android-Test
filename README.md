# Revolut-Android-Test

## Requirements
You should implement one screen with a list of currencies. 

The app must download and update rates every 1 second using API
List all currencies you get from the endpoint (one per row). Each row has an input where you can enter any amount of money. When you tap on a currency row it should slide to the top and it's input becomes the first responder. When you’re changing the amount the app must simultaneously update the corresponding value for other currencies.
Use any libraries and languages(java/kotlin) you want. Please, note that the solution should be production ready.

## Build

This app relies on:

* buildtools v 29.0.3
* compile sdk 29
* AGP 3.6.2
* Gradle 5.6.4
* view binding it's enabled to AS 3.6 or avobe it's required

min sdk it's 21

## Demo

https://gfycat.com/disgustinginfatuatedcapeghostfrog

## Disclaimer

The latest di approach to allow save state on process death its a vit verbose.
 In order to maintain the previous  set up something likes AssistedInject would have been needed.
