import pyro_setting
import Pyro4


if __name__ == '__main__':
    
#     uri=raw_input("What is the Pyro uri of the greeting object? ").strip()
    name=raw_input("What is your name? ").strip()
    sa = Pyro4.Proxy("PYRONAME:salute")
    print sa.sayHi(name)   