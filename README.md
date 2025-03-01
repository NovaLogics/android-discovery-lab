<h1 align="center" >  Android Discovery Lab  <br> ♨ [ ᴀɴᴅʀᴏɪᴅ  ᴘʀᴏᴊᴇᴄᴛ ] ♨</h1>

This repository documents my journey through the Android Developer guidelines using Kotlin. It includes step-by-step instructions, screenshots, and explanations for each unit.

---

<br/>

# Experiment Unit 03: Coroutine Contexts and Dispatchers - Kotlin Coroutines

In this unit, I explored coroutine contexts and dispatchers in Kotlin Coroutines. Dispatchers define the thread or thread pool in which a coroutine runs, allowing us to control where tasks are executed. This is essential for tasks like network calls, database operations, and UI updates.

<br/>

<div align="center">
<img src="./_archive/kotlin-coroutine.png" />
</div>

---

#### Key Steps and Learnings:

1. **What are Coroutine Contexts and Dispatchers?**
    - **Coroutine Context**: Defines the environment in which a coroutine runs, including the thread or dispatcher.
   
    - **Dispatchers**: Specify the thread or thread pool for coroutine execution. Common dispatchers include:
   
        - **Dispatchers.Main**: Runs coroutines on the main thread (for UI updates).
      
        - **Dispatchers.IO**: Optimized for I/O operations (e.g., network calls, database access).
      
        - **Dispatchers.Default**: Used for CPU-intensive tasks (e.g., sorting, complex calculations).
      
        - **Dispatchers.Unconfined**: Not confined to a specific thread; resumes in the thread where the suspend function is called.
      
        - **newSingleThreadContext**: Creates a new single thread for coroutine execution.


2. **Using Dispatchers in Coroutines**:
    - I demonstrated how to launch coroutines with different dispatchers:
      ```kotlin
      // Using Dispatchers.IO for network calls
      GlobalScope.launch(Dispatchers.IO) {
          Log.d(TAG, "COROUTINE | Thread : ${Thread.currentThread().name}")
          val networkCallOne = doNetworkCall()
          Log.d(TAG, networkCallOne)
      }
 
      // Using Dispatchers.Main for UI updates
      GlobalScope.launch(Dispatchers.Main) {
          Toast.makeText(context, "UI Update on Main Thread", Toast.LENGTH_LONG).show()
      }
 
      // Using newSingleThreadContext for custom thread
      GlobalScope.launch(newSingleThreadContext("COROUTINE-THREAD")) {
          Log.d(TAG, "COROUTINE | Thread : ${Thread.currentThread().name}")
      }
      ```  

3. **Switching Contexts with `withContext`**:
    - The `withContext` function allows us to switch the context of a coroutine.
   
    - Example: Performing a network call on a background thread and updating the UI on the main thread:
   
      ```kotlin
      fun testCoroutineContexts(context: Context) {
          GlobalScope.launch(Dispatchers.IO) {
              Log.d(TAG, "COROUTINE | Thread : ${Thread.currentThread().name}")
 
              val networkCallOne = doNetworkCall()
              Log.d(TAG, networkCallOne)
 
              withContext(Dispatchers.Main) {
                  Toast.makeText(context, networkCallOne, Toast.LENGTH_LONG).show()
              }
          }
      }
      ```  

4. **Observing the Behavior**:
    - Logs show the coroutine running on different threads based on the dispatcher:
        - `Dispatchers.IO`: Runs on a background thread (`DefaultDispatcher-worker-1`).
      
        - `Dispatchers.Main`: Runs on the main thread.
      
    - Logs:
      ```
      20:42:40.493  D  COROUTINE | Thread : DefaultDispatcher-worker-1
      20:42:42.496  D  1st Network Call
      ```  
      
    - Toast Message:
   
    <div align="center">
    <img src="./_archive/screenshots/screen-02.png" width="320" />
    </div>

---

#### Key Takeaways:
- **Dispatchers** control where coroutines run, ensuring tasks are executed on the appropriate thread.
- **`withContext`** allows easy switching between contexts, making it simple to perform background tasks and update the UI.
- **`newSingleThreadContext`** is useful for creating custom threads for specific tasks.

---
