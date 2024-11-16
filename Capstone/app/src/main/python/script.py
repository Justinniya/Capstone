"""
import sys
from os.path import dirname, join
from com.chaquo.python import Python

def main(code):
    file_dir = str(Python.getPlatform().getApplication().getFilesDir())

    filename = join(dirname(file_dir), 'file.text')

    try:
        original_stdout = sys.stdout
        sys.stdout = open(filename,'w',encoding = 'utf8',errors='ignore')
        exec(code)
        sys.stdout.close()
        sys.stdout = original_stdout
        output = open(filename ,'r').read()

    except Exception as e:
        sys.stdout = original_stdout
        output = e

    return str(output) """

"""import sys
from io import StringIO
from com.chaquo.python import Python

def main(code):
    # Create a string buffer to capture the output
    buffer = StringIO()
    original_stdout = sys.stdout  # Save the original stdout
    sys.stdout = buffer  # Redirect stdout to the buffer

    try:
        # Execute the user-provided Python code
        exec(code)
        output = buffer.getvalue()  # Capture any printed output
    except Exception as e:
        output = str(e)  # Capture any error message
    finally:
        sys.stdout = original_stdout  # Restore original stdout

    return output"""


'''import sys
from io import StringIO
import threading

def run_flask(app_code):
    exec(app_code)

def main(code):
    if 'Flask' in code:
        flask_thread = threading.Thread(target=run_flask, args=(code,))
        flask_thread.start()
        return "Flask server is running."
    else:
        buffer = StringIO()
        original_stdout = sys.stdout  # Save the original stdout
        sys.stdout = buffer  # Redirect stdout to the buffer

        try:
            exec(code)
            output = buffer.getvalue()  # Capture any printed output
        except Exception as e:
            output = str(e)  # Capture any error message
        finally:
            sys.stdout = original_stdout  # Restore original stdout

        return output'''

import sys
from io import StringIO
import threading
from flask import Flask

def run_flask(app_code):
    # Execute the Flask app code in this function
    exec(app_code)  # This will run the Flask application code

def main(code):
    if 'Flask' in code:
        # Start the Flask server in a separate thread
        flask_thread = threading.Thread(target=run_flask, args=(code,))
        flask_thread.start()  # Start the Flask server
        return "Flask server is running in a separate thread."
    else:
        buffer = StringIO()
        original_stdout = sys.stdout  # Save the original stdout
        sys.stdout = buffer  # Redirect stdout to the buffer

        try:
            exec(code)  # Execute non-Flask code
            output = buffer.getvalue()  # Capture any printed output
        except Exception as e:
            output = str(e)  # Capture any error message
        finally:
            sys.stdout = original_stdout  # Restore original stdout

        return output
