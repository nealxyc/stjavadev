import pyro_setting
import com.nealxyc.plugintest.javapythonbridge.SaluteImpl as SaluteImpl
import Pyro4


class SaluteServer:
    def __init__(self):
        self.impl = SaluteImpl()
        pass
    def sayHi(self, name):
        return self.impl.sayHi(name)

def main():
    sa = SaluteServer()
    daemon = Pyro4.Daemon()
    ns=Pyro4.locateNS()
    
    uri = daemon.register(sa)
    print uri
    ns.register('salute', uri)
    print "Ready."
    try:
        daemon.requestLoop()
    finally:
        daemon.close()
         
if __name__ == '__main__':
    
#     Pyro4.config.SERIALIZERS_ACCEPTED = set(['json', 'marshal', 'pickle'])
#     Pyro4.config.SERIALIZER = "pickle"
#     
    main()
    
