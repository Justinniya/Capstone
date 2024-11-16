import subprocess
import os
import signal

flask_process = None

def start_flask():
    global flask_process
    # Start the Flask server
    flask_process = subprocess.Popen(['python', 'script.py'], shell=True)

def stop_flask():
    global flask_process
    if flask_process:
        os.kill(flask_process.pid, signal.SIGTERM)
        flask_process = None
