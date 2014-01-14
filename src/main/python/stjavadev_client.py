import pyro_setting
import Pyro4


if __name__ == '__main__':
    jdev = Pyro4.Proxy("PYRONAME:stjavadev")
    prj_name=raw_input("Focus Project: ").strip()
    print jdev.focusProject(prj_name)
    cls_name=raw_input("Full Class Name: ").strip()
    print jdev.getAllMethods(cls_name)