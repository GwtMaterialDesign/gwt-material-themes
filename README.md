<img src="http://i.imgur.com/jxTSZ3K.png" />

# gwt-material-themes 

Gwt Material Design Themes for https://github.com/GwtMaterialDesign/gwt-material <br>

[![Build Status](https://travis-ci.org/GwtMaterialDesign/gwt-material-themes.svg?branch=master)](https://travis-ci.org/GwtMaterialDesign/gwt-material-themes) [![Join us](https://img.shields.io/badge/slack-channel-purple)](https://gmd-project.slack.com)


## Usage
```xml
<dependency>
    <groupId>com.github.gwtmaterialdesign</groupId>
    <artifactId>gwt-material-themes</artifactId>
    <version>2.4.0-rc2</version>
</dependency>
```

## Changelog
You can view the changelog [here](https://github.com/GwtMaterialDesign/gwt-material-themes/wiki/Changelog)

Import the theme in your GWT Module
```xml
<inherits name="gwt.material.design.themes.ThemeBlue"/>
```
## Dynamic Themes
Starting GMD 2.0 we supported dynamic theming.
#### Step 1: Choose GMD Theme Resources you want to include into your app.
```xml
<inherits name="gwt.material.design.themes.ThemeAmberResources"/>
<inherits name="gwt.material.design.themes.ThemeBlueResources"/>
<inherits name="gwt.material.design.themes.ThemeBrownResources"/>
<inherits name="gwt.material.design.themes.ThemeGreenResources"/>
<inherits name="gwt.material.design.themes.ThemeGreyResources"/>
<inherits name="gwt.material.design.themes.ThemeOrangeResources"/>
<inherits name="gwt.material.design.themes.ThemePinkResources"/>
<inherits name="gwt.material.design.themes.ThemePurpleResources"/>
<inherits name="gwt.material.design.themes.ThemeRedResources"/>
<inherits name="gwt.material.design.themes.ThemeYellowResources"/>
```
#### Step 2: Create your theme switcher (Below is a custom example)
A ComboBox widget that contains lists of theme selection.
[Sample](https://github.com/GwtMaterialDesign/gwt-material-demo/blob/release_2.0/src/main/java/gwt/material/design/demo/client/application/menu/MenuView.java#L74)

#### Step 3: Create your Theme Manager (Below is a custom example)
A Custom theme manager to store selected theme to browser’s cache.
[Theme Manager](https://github.com/GwtMaterialDesign/gwt-material-demo/blob/release_2.0/src/main/java/gwt/material/design/demo/client/ThemeManager.java)


## Follow Us
<a href="https://plus.google.com/u/0/communities/108005250093449814286"> Google Plus</a>
