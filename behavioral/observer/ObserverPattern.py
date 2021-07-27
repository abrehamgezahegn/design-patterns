from abc import ABC, abstractmethod

class Publisher(ABC):
    
    @abstractmethod
    def addSubscriber(self):
        pass
  
    @abstractmethod
    def removeSubscriber(self):
        pass

    @abstractmethod
    def notifySubscribers(self):
        pass



class Subscriber(ABC):
  
    @abstractmethod
    def update(self):
        pass



class MagazineCompany(Publisher):
    def __init__(self) -> None:
        super().__init__()
        self.subscriptions = []

    def addSubscriber(self,type, subscriber):
        subscription = {"type": type, "subscriber": subscriber }
        self.subscriptions.append(subscription)
    
    def removeSubscriber(self,type,subscriber):
        filtered = []
        for subscription in self.subscriptions:
            if subscription["type"] != type and subscription["subscriber"].name != subscriber.name:
                filtered.append(subscription)
        self.subscriptions = filtered
    
    def notifySubscribers(self):
        for subscription in self.subscriptions:
            subscription["subscriber"].update(subscription["type"])
        



class EmailUser(Subscriber):

    def __init__(self, name) -> None:
        super().__init__()
        self.name = name

    def update(self, type):
        print("Sending email to user about: ", type )


def main():
    mgz = MagazineCompany()
    user_1  = EmailUser("michael")
    user_2  = EmailUser("jim")

    mgz.addSubscriber("New sports magazine", user_1)
    mgz.addSubscriber("New movies magazine", user_2)

    mgz.removeSubscriber("New sports magazine", user_1)

    mgz.notifySubscribers()

main()

