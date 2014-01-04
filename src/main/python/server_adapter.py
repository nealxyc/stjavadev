from com.nealxyc.plugintest.javapythonbridge import ServerAdapter
import salute_server

class ServerAdapter(ServerAdapter):
    def __init__(self):
        pass
    def run(self):
        return salute_server.main()
