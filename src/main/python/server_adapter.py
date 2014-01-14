from com.nealxyc.plugintest.javapythonbridge import ServerAdapter
import stjavadev_server

class ServerAdapter(ServerAdapter):
    def __init__(self):
        pass
    def run(self):
        return stjavadev_server.main()


if __name__ == "__main__":
    ServerAdapter().run()