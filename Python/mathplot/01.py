from manimlib.imports import *
import os
import pyclbr


class Shapes(Scene):
    def construct(self):
        line=Line(np.array([3,0,0]),np.array([5,0,0]))
        self.add(line)



if __name__ == "__main__":
    module_name = 'demo'   #Name of current file
    module_info = pyclbr.readmodule(module_name)

    for item in module_info.values():
        if item.module==module_name:
            print(item.name)
            os.system("python -m manim manim_tutorial_P37.py %s -l" % item.name)