from abc import ABC, abstractmethod
import copy
import uuid

class Person(ABC):
    def __init__(self,name,personality ) -> None:
        self.name = name
        self.personality = personality
    
    @abstractmethod
    def clone(self):
        pass

class SalesMan(Person):
    def __init__(self, name,personality, sales_record) -> None:
        super().__init__(name,personality)
        self.id = uuid()
        self.sales_record = sales_record
        self.clones = dict()

    
    def make_sale():
        print("making sale")
    
    def register(self, identifier, obj):
        self.clones[identifier] = obj

    def unregister(self, identifier):
        del self.clones[identifier]

    
    def clone(self, identifier, **attrs):
        found = self.clones.get(identifier)
        if not found:
            raise ValueError(f'Incorrect object identifier:{identifier}')
        obj = copy.deepcopy(self)

        for key in attrs:
            setattr(obj, key, attrs[key])
        return obj


class Prototype:
    def __init__(self):
        self.objects = dict()

    def register(self, identifier, obj):
        self.objects[identifier] = obj

    def unregister(self, identifier):
        del self.objects[identifier]

    def clone(self, identifier, **attrs):
        found = self.objects.get(identifier)
        if not found:
            raise ValueError(f'Incorrect object identifier:{identifier}')
        obj = copy.deepcopy(found)

        for key in attrs:
            setattr(obj, key, attrs[key])
        return obj

def main():
    dwight = SalesMan("Dwight", "Distinct", 140501)
    dwight.register(dwight.id, dwight)
    dwight_clone_1 = dwight.clone(dwight.id, name="Dwight 2", personality=dwight.personality , sales_record=dwight.sales_record)



