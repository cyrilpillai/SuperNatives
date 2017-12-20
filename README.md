# Super Natives

Super Natives is a sample app that showcases the use of MVP architecture to build *maintainable & scalable* Android apps.


## What does it do?
It is a very straightforward app with two screens.
<br>The first screen displays a list of superheroes & clicking on a superhero opens up a details screen that displays the details of that superhero.

## How does it look?

<p align="center">
  <img src="/assets/list_screen.png" alt="Screenshots"  height="500" width="300"/>
  <img src="/assets/details_screen.png" alt="Screenshots"  height="500" width="300"/>
</p>

## Architecture
This app follows the **Model-View-Presenter** architecture. If you are not familiar with this architectural pattern or aren't aware of its specifics then read [this](https://antonioleiva.com/mvp-android/) to quickly get an overview of MVP and how it fits in the Android world.

## Package Structure
> app
>> heroes_list
>>> model<br>
>>> view<br>
>>> presenter<br>
>>> contract<br>
>>> repo<br>
>>> di<br>

This app uses a combination of `package-by-feature` and `package-by-layer`. The top level packages are feature based. Inside each `feature-package`, the code is split into different packages based on the layer. Common code shared between multiple features is present at the top most level with `feature-packages`. This structure has worked for me and I have been using it for some time now. Read [this](http://www.javapractices.com/topic/TopicAction.do?Id=205) blogpost to know more about packaging structures.

## Data Source
All of the SuperHero data is fetched from [SuperHeroAPI](http://superheroapi.com/). Surprisingly, they don't have a listing API and only provide a details API which returns details of a SuperHero based on the `character_id`. But, they do have the list of SuperHeroes [here](http://superheroapi.com/ids.html). As the list is present in an `HTML` format, I had to convert it into `JSON` format and host it on GitHub. You can get the list of SuperHeroes with their `character_ids` [here](https://cyrilpillai.github.io/SuperHeroes/list.json).

## Data Strategy
This app adheres to the `offline-first` principles. It uses `ObjectBox` to cache all of the network responses to minimise server trips. A network call is made to get the required data only when it isn't already available locally. This makes the app usable even when the device isn't connected to the `INTERNET`. Checkout http://offlinefirst.org/ to know more about `offline-first architecture`.

## Getting Started

### Clone the Repository

Alright. You know the drill.

```
$ git clone https://github.com/cyrilpillai/SuperNatives.git
```

### Prerequisites
Get an API key to access the `SuperHeroAPI` from [here](http://superheroapi.com/).

### Open and Run in Android Studio

After cloning the repo:

1. Open the project in Android Studio.

2. Create `gradle.properties`, if it doesn't exist.

<p align="center">
  <img src="https://media.giphy.com/media/xUNd9X3bbwIuMyDxkY/giphy.gif" alt="Create gradle.properties"/>
</p>

3. Add the API key to `gradle.properties` as `SUPERHERO_API_KEY` to access it in the codebase while making sure you **DON'T REVEAL** it to the outside world. <br> Copy the snippet and change `"YOUR_API_KEY"` to the actual API key.
```
# API Keys
SUPERHERO_API_KEY = "YOUR_API_KEY"
```

## Interesting things to lookout for
* **ObjectBox** - It is an alternative to `SQLite` and the best part about ObjectBox is `Migrations` are handled automatically.
* **ObjectBox Browser** - I used ObjectBox as it is the new kid on the block and I wanted to try it out. `DEBUGGING` a database is really helpful when building apps. [ObjectBox Browser](http://objectbox.io/objectbox-1-1-introduces-data-browser/) is something that makes this possible.
* **Dagger2** - `Android Injector` really reduces the boilerplate you had to write previously.
* **AdapterDelegates** - Really helps in building complex RecyclerViews while also ensuring the code is clean and modularized.
* **Stetho** - This is one of the libraries I add to every new project I create. Stetho makes `DEBUGGING` super simple.
* **Data Binding** - If you are still writing boilerplate code to bind views yourself, you need to checkout [DataBinding](https://developer.android.com/topic/libraries/data-binding/index.html) right now. Personally, I use it to just bind the views as I am against the idea of adding logic to `XMLs`, but DataBinding can do a lot more than just bind views.
* **Starter Pattern** - This is pretty useful in non trivial apps. Read [this](https://hackernoon.com/object-oriented-tricks-4-starter-pattern-android-edition-1844e1a8522d) to know about it.
* **Vector Drawables** - `STOP` using multiple versions of the same image to support the different density buckets. Enable [Vector Drawables](https://developer.android.com/guide/topics/graphics/vector-drawable-resources.html) in your app-level `build.gradle` and start using them to reduce the size of the `APK` and also your work of creating/managing versions of the same image.
* **Screener** - Create wonderful screenshots with just a few clicks on your Android phone. Click [here](https://play.google.com/store/apps/details?id=de.toastcode.screener&hl=en) to download the app.


### Libraries Used
* [Support Library](https://developer.android.com/topic/libraries/support-library/index.html)
* [Retrofit](http://square.github.io/retrofit/)
* [OkHttp](http://square.github.io/okhttp/)
* [Gson](https://github.com/google/gson)
* [Picasso](http://square.github.io/picasso/)
* [Dagger 2](https://google.github.io/dagger/)
* [ObjectBox](http://objectbox.io/)
* [AdapterDelegates](https://github.com/sockeqwe/AdapterDelegates)
* [Stetho](http://facebook.github.io/stetho/)
* [FastScroll](https://github.com/FutureMind/recycler-fast-scroll)

## License
```
Copyright 2017 Cyril Pillai

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
