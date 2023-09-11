# Quotes Application

The Quotes Application is a Java program that allows users to retrieve random quotes from a JSON file containing a list of quotes. It also provides functionality to write a new quote to another JSON file from an Api.

## Features

- Retrieve Random Quote: The application reads a JSON file containing a list of quotes. It randomly selects a quote from the list and displays it along with the author.

- Write New Fitched quote from an API URL: The application provides the ability to add a new quote and its author to a different JSON file.


## Usage

### Retrieve Random Quote

- The application will display a random quote along with the author when you run it using the provided Gradle command.

### Write New Fitched quote from an API URL

- The application will display a **Fitched random quote from an API URL** along with the author when you run it using the provided Gradle command.
- **API URL : https://favqs.com/api/qotd** 
## Notes

- Make sure you have the appropriate permissions to read from and write to files in the specified directories.
- The application reads quotes from "recentquotes.json" and writes new quotes to "writeRecentquotes.json". You can adjust these filenames as needed.
    

---
# you need to add Gson (Google's JSON library) to your project


To use Gson in your Java project, you need to add it as a dependency in your build configuration. Below are the steps to add Gson to your Gradle-based project:

1. Open your project's `build.gradle` file.

2. Inside the `dependencies` block, add the following line:

   ```gradle
   dependencies {
       // Other dependencies
       implementation 'com.google.code.gson:gson:2.8.9' // Replace with the latest version
   }
   ```

   Replace `'2.8.9'` with the latest version of Gson available.

3. Save the `build.gradle` file.

4. Open your terminal or command prompt.

5. Navigate to your project's root directory.

6. Run the following command to sync your project and download the Gson library:

   ```sh
   ./gradlew build
   ```

   This command will update your project with the Gson library.

With Gson added to your project, you can now use it to serialize and deserialize JSON data.

Remember to keep an eye on the official Gson repository for any updates or newer versions: [Gson on Maven Central](https://search.maven.org/artifact/com.google.code.gson/gson).

