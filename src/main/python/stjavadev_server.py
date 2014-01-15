import pyro_setting
import com.nealxyc.stjavadev.STJavaDev as JavaServer
import Pyro4
import threading
import completion_requestor

class STJavaDevServer:
    def __init__(self):
        self.java_server = JavaServer()
        pass
    def getAllMethods(self, name):
        return list(self.java_server.getAllMethods(name))
    
    def focusProject(self, prj_name):
        if self.java_server.focusProject(prj_name):
            return 'Found Java Project: %s' % prj_name
        return 'Project not found.'
    
    def codeComplete(self, file_path, offset):
        print 'Finding code completion...on file %s, offset %i' % (file_path, offset)
        if self.java_server.codeComplete(file_path, offset, completion_requestor.CompletionRequestor()):
            pass
        else:
            print 'can not call code completion...on file %s, offset %i' % (file_path, offset)
    
class Pyro4NSServer(threading.Thread):
    def __init__(self):
        print 'Initialing Naming Server ...'
        threading.Thread.__init__(self)
    def run(self):
        print 'Starting Naming Server ...'
        Pyro4.naming.startNSloop()
        pass
    


def main():
    
    # Start a Naming Server in a different thread first
    ns_thread = Pyro4NSServer()
    ns_thread.start()
    
    #
    sa = STJavaDevServer()
    daemon = Pyro4.Daemon()
    ns=Pyro4.locateNS()
    
    uri = daemon.register(sa)
    print uri
    ns.register('stjavadev', uri)
    print "Ready."
    try:
        daemon.requestLoop()
    finally:
        daemon.close()
        
    ns_thread.join(500)
         
if __name__ == '__main__':
    
#     Pyro4.config.SERIALIZERS_ACCEPTED = set(['json', 'marshal', 'pickle'])
#     Pyro4.config.SERIALIZER = "pickle"
#     
    main()
    
