# TecXA
TecX App


```
MyAIProject/
├── app/
│   ├── build.gradle (Add dependencies here)
│   └── src/
│       └── main/
│           ├── java/com/yourpackage/
│           │   ├── MainActivity.kt      (The UI & Button logic)
│           │   ├── ModelRunner.kt       (The ONNX logic)
│           │   └── CharacterEncoder.kt  (The Flatten/Encode logic)
│           ├── res/
│           │   ├── layout/
│           │   │   └── activity_main.xml (The XML UI)
│           │   └── raw/
│           │       ├── dict_model.onnx   (The Model)
│           │       ├── vocab.csv         (The Mapping)
│           │       └── labels.txt        (The Categories)
│           └── AndroidManifest.xml
```
Final Integration Checklist
The Flatten Logic: Verify the flatten function in your Kotlin CharacterEncoder exactly matches the one in your Python script (e.g., using : for keys and spaces for separators).
The Vocabulary: Ensure vocab.csv includes your special tokens (<SOS>, <EOS>, <PAD>) and that the indices match the stoi used during training.
The Input Shape: In ModelRunner.kt, make sure the longArrayOf(1, encodedInput.size.toLong()) matches the dynamic axes you set during the ONNX export.
Label Mapping: Ensure the order of lines in labels.txt matches the order of your classes (e.g., Line 0 = "Category A", Line 1 = "Category B").
4. How to Test
Run the app on a physical device or emulator.
Paste a JSON like {"status": "ok", "temp": 24} into the text box.
Click Predict—the app will flatten the JSON, encode it into numbers, pass it to the ONNX model, and show the result.
