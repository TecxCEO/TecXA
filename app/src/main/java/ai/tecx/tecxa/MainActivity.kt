// Inside your MainActivity onCreate
val inputField = findViewById<EditText>(R.id.inputJson)
val btn = findViewById<Button>(R.id.btnPredict)
val resultView = findViewById<TextView>(R.id.txtResult)

btn.setOnClickListener {
    val rawText = inputField.text.toString()
    try {
        // 1. Convert text to a Map
        val mapType = object : TypeToken<Map<String, Any>>() {}.type
        val inputMap: Map<String, Any> = Gson().fromJson(rawText, mapType)

        // 2. Encode and Predict
        val encoded = characterEncoder.encode(inputMap)
        val prediction = modelRunner.predict(encoded)

        resultView.text = "Result: $prediction"
    } catch (e: Exception) {
        resultView.text = "Error: Invalid JSON Format"
    }
}
