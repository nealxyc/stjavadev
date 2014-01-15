
import sys
sys.path.append('G:\\Workspace 2\\com.nealxyc.plugintest\\src\\main\\python')
sys.path.append('G:\\Workspace 2\\com.nealxyc.plugintest\\bin')
sys.path.append('G:\\jython2.7b1\\Lib')

import Pyro4

Pyro4.config.SERIALIZERS_ACCEPTED = set(['json', 'marshal', 'pickle'])
Pyro4.config.SERIALIZER = "json"



if __name__ == '__main__':
    pass