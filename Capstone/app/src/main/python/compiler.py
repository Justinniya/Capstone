def run_python_code(code):
    try:
        result = eval(code)
        return str(result)
    except Exception as e:
        return "Error: " + str(e)