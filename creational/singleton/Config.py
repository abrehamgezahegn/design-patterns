class SingletonType(type):
    _instances = {}

    def __call__(cls, *args, **kwargs):
        print("call inside SingletonType", cls, *args, **kwargs)
        print("instances", cls._instances)
        if cls not in cls._instances:
            cls._instances[cls] = super(SingletonType, cls).__call__(*args, **kwargs)
            return cls._instances[cls]


class Config(metaclass=SingletonType):
    def __init__(self, endpoint):
        self.endpoint = endpoint

    def get_config(self):
        return {"endpoint": self.endpoint}


if __name__ == "__main__":
    import sys

    endpoint = sys.argv[1]

    a = Config(endpoint)
    b = Config(endpoint)
    # c = Config("gasdgs")
    print(a is b)
    a.get_config()
