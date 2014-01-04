import Pyro4

Pyro4.config.SERIALIZERS_ACCEPTED = set(['json', 'marshal', 'pickle'])
Pyro4.config.SERIALIZER = "pickle"

if __name__ == '__main__':
    pass