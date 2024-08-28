Task: Concurrent Monitoring System

Task Description:

Your task is to create a simple monitoring system that uses multithreading for efficient data processing and monitoring. The system will have two main tasks:

Data Collection: A thread that generates data (simulated as random numbers) and stores it in a shared structure.
Data Processing: A thread that reads data from the shared structure, processes it (e.g., computes the sum), and reports the results.
Synchronization is required to ensure data consistency and to avoid issues related to concurrent access to shared resources.

Requirements:

Thread Implementation:

Create a class DataCollector implementing Runnable that generates random numbers and adds them to a shared list.
Create a class DataProcessor implementing Runnable that reads data from the list, processes it, and reports the results.
Synchronization:

Use synchronized blocks or synchronized methods to protect access to the shared data list.
Coordination:

Apply wait and notify methods to coordinate communication between threads. The processing thread should wait until the collecting thread provides data.
ExecutorService Shutdown:

Use ExecutorService to manage threads. Ensure proper shutdown of the ExecutorService after the application has finished executing.
Result Reporting:

The processing thread should regularly report the sum of the processed data.
