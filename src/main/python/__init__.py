import JavaInit
import IScript


class PyScript(IScript):
    def __init__(self):
        pass

    def run(self, b):
        print(JavaInit.f())
        j = JavaInit()
        print(j.f())
        j.a += b
        print(j.f())
