<h1 align="center" >  Android Discovery Lab  <br> ♨ [ ᴀɴᴅʀᴏɪᴅ  ᴘʀᴏᴊᴇᴄᴛ ] ♨</h1>

This repository documents my journey through the Android Developer guidelines using Kotlin. It includes step-by-step instructions, screenshots, and explanations for each unit.

---

## Unit 1: First Android Project (Using Jetpack Compose)
In this unit, I created my first Android project using Android Studio. The goal was to familiarize myself with the Android development environment, project structure, and basic concepts like activities, layouts, and the Android Manifest.

---

### Steps by Step

#### 1. Launch Android Studio
- Double-click the Android Studio icon to launch the IDE.

#### 2. Create a New Project
- In the **Welcome to Android Studio** dialog, click **New Project**.  
  ![Welcome Screen](./_archive/screenshots/screen-01.png)

#### 3. Select a Project Template
- The **New Project** window opens with a list of templates provided by Android Studio.
- Ensure the **Phone and Tablet** tab is selected.
- Click the **Empty Activity** template to select it as the template for your project.
- Click **Next**.  
  ![Template Selection](./_archive/screenshots/screen-02.png)

#### 4. Configure Your Project
- In the **New Project** dialog, configure your project as follows:
    - **Name**: Enter the name of your project, e.g., `AndroidProject`
        - Use **PascalCase** for project names (e.g., `MyFirstApp`)
    - **Package Name**: This is a unique identifier for your app, typically in the format `com.example.appname`.
        - Example: `com.example.androidproject`
        - The package name is used to uniquely identify your app on the Google Play Store and in the Android ecosystem.
    - **Save Location**: Leave this field as the default or choose a custom location on your computer.
    - **Language**: Select **Kotlin**.
    - **Minimum SDK**: Select **API 24: Android 7.0 (Nougat)**.
        - The Minimum SDK indicates the oldest version of Android your app will support.  
          ![Project Configuration](./_archive/screenshots/screen-03.png)

#### 5. Finish and Wait for Setup
- Click **Finish**.
- Android Studio will set up your project. This may take a few minutes.

#### 6. Explore the Android Studio Interface
- Once the project is set up, click **Split** on the top right of Android Studio. This allows you to view both the code and design simultaneously.
    - You can also switch between **Code** (code-only view) and **Design** (design-only view).
- The interface is divided into three main areas:
    1. **Project View**: Displays the files and folders of your project.
    2. **Code View**: Where you write and edit your Kotlin or XML code.
    3. **Design View**: A preview of your app’s layout.  
       ![Android Studio Interface](./_archive/screenshots/screen-04.png)

---

### Key Concepts

#### Project Structure
- **`app/src/main/java`**: Contains the Kotlin source code for your app.
- **`app/src/main/res`**: Contains resources like layouts (`layout/`), drawables (`drawable/`), and values (`values/`).
- **`AndroidManifest.xml`**: Defines the app’s components (e.g., activities) and permissions.

#### Empty Activity Template
- The **Empty Activity** template creates a single screen (activity) with a basic layout (`activity_main.xml`) and a corresponding Kotlin file (`MainActivity.kt`).

#### Minimum SDK
- Choosing **API 24: Android 7.0 (Nougat)** ensures your app can run on devices with Android 7.0 and above.

---

---

## Getting Started with the first App

1. **Understand the Code Structure**:
    - Open `MainActivity.kt` in **Code View**.
    - Notice the automatically generated functions:
        - `onCreate()`: Entry point of the app.
        - `setContent()`: Defines the layout using composable functions.

2. **Key Functions**:
    - `onCreate()`:
        - Called when the app starts.
        - Sets up the UI by calling `setContent()`.
    - `setContent()`:
        - Uses composable functions (marked with `@Composable`) to build the UI.

3. **Composable Functions**:
    - Annotated with `@Composable`.
    - Function names are capitalized.
    - Cannot return any value.
    - Example:

      ```kotlin
      @Composable
      fun Greeting(name: String, modifier: Modifier = Modifier) {
          Text(text = "Hello $name!", modifier = modifier)
      }
      ```  

4. **Update the Greeting Function**:
    - Change the text to introduce yourself:

      ```kotlin
      @Composable
      fun Greeting(name: String, modifier: Modifier = Modifier) {
          Text(text = "Hi, my name is $name!", modifier = modifier)
      }
      ```  

5. **Preview Your Changes**:
    - Use the `GreetingPreview()` function to see your UI changes without running the app.
    - Annotate with `@Preview` to enable previews in Android Studio.
    - Example:

      ```kotlin
      @Preview(showBackground = true)
      @Composable
      fun GreetingPreview() {
          AndroidDiscoveryLabTheme {
              Greeting("Your Name")
          }
      }
      ```  

    - Set `showBackground = true` to add a background to the preview.

6. **Personalize the Greeting**:
    - Replace `"Android"` with your name in the `Greeting()` function.
    - Rebuild the app to see your personalized greeting card.  

---

---

## Change the Background Color

1. **Add a Surface to Your Text**:
    - A `Surface` is a container that lets you modify UI appearance (e.g., background color, border).
    - Surround the `Text` with a `Surface` using:
        - **Windows:** Press `Alt + Enter`
        - **Mac:** Press `Option + Enter`
    - Select **"Surround with Container"** and replace `Box` with `Surface()`.

2. **Modify the Surface Color**:
    - Add a `color` parameter to `Surface`:

      ```kotlin
      @Composable
      fun Greeting(name: String, modifier: Modifier = Modifier) {
          Surface(color = Color) {
              Text(
                  text = "Hi, my name is $name!",
                  modifier = modifier
              )
          }
      }
      ```  

    - If `Color` is red (unresolved), add this import at the top:

      ```kotlin
      import androidx.compose.ui.graphics.Color
      ```

3. **Optimize Imports**:
    - Keep imports organized alphabetically.
    - Remove unused imports via:
        - **Menu:** `Code > Optimize Imports`
        - **Search:** `Help > Optimize Imports`

4. **Select a Color**:
    - Add a period (`.`) after `Color` to see suggestions.
    - Choose a color, e.g., `Color.Cyan`:

      ```kotlin
      @Composable
      fun Greeting(name: String, modifier: Modifier = Modifier) {
         Surface(color = Color.Cyan) {
             Text(
                 text = "Hi, my name is $name!",
                 modifier = modifier
             )
         }
      }
      ```  

5. **Preview the Changes**:
    - Check the updated background color in Android Studio’s preview.  

---

---

## Add Padding

1. **Use a Modifier for Padding**:
    - A `Modifier` is used to style or position a composable.
    - The `Modifier.padding()` function adds space around an element.

2. **Apply Padding to Text**:
    - Modify the `modifier` parameter to include `padding(24.dp)`:

      ```kotlin
      @Composable
      fun Greeting(name: String, modifier: Modifier = Modifier) {
          Surface(color = Color.Cyan) {
              Text(
                  text = "Hi, my name is $name!",
                  modifier = modifier.padding(24.dp)
              )
          }
      }
      ```  

3. **Import Required Dependencies**:
    - Add these imports to the top of your file:

      ```kotlin
      import androidx.compose.ui.unit.dp
      import androidx.compose.foundation.layout.padding
      ```

    - Optimize imports via:
        - **Menu:** `Code > Optimize Imports`
        - **Search:** `Help > Optimize Imports`

4. **Experiment with Customization**:
    - Try different colors and padding sizes to personalize your app.

🎉 **Congratulations!** You've successfully built your first Android app using Jetpack Compose! 🚀  

![Screen](./_archive/screenshots/screen-05.png)
