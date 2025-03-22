import sys
import threading
import os
import signal
from io import StringIO




stop_event = threading.Event()

app_instance = None
flask_thread = None

def run_flask(app_code):
    global app_instance
    local_vars = {"__name__": "__main__"}
    exec(app_code, local_vars)

#     app_instance.run(host="0.0.0.0", port=5000, debug=True, use_reloader=True)
#     if "app" in local_vars:
#
#     else:
#         print("Error: No Flask app instance found.")


def stop_flask():
#     flask_thread.kill()
#     flask_thread.join()
#     flask_thread = None
    pass

def main(code, action="start"):
    global flask_thread

    if action == "stop":
        return stop_flask()

    if "Flask" in code:
        buffer = StringIO()
        original_stdout = sys.stdout
        sys.stdout = buffer
        stop_event.clear()
        flask_thread = threading.Thread(target=run_flask, args=(code,), daemon=True)
        flask_thread.start()
        return "Flask server started. Open http://127.0.0.1:5000/"

    buffer = StringIO()
    original_stdout = sys.stdout
    sys.stdout = buffer

    try:
        exec(code, {"__name__": "__main__"})
        output = buffer.getvalue()
    except Exception as e:
        output = str(e)
    finally:
        sys.stdout = original_stdout

    return output
