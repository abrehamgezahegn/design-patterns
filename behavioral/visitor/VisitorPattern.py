from abc import ABC, abstractmethod, abstractproperty
import csv
from os import write


class Visitor(ABC):
    @abstractmethod
    def visitTable(self):
        pass
    
    @abstractmethod
    def visitDB(self):
        pass


class DBComponent(ABC):
    
    @abstractmethod
    def accept(self, visitor):
        pass


class User(DBComponent):
    def __init__(self,name,email,avatar) -> None:
        super().__init__()
        self.name = name
        self.email = email
        self.avatar = avatar
    
    def updateName(self, name):
        self.name = name
    
    def updateEmail(self, email):
        self.email = email
    
    def updateAvatar(self,avatar):
        self.avatar = avatar
    
    def accept(self, visitor):
        visitor.visitTable(self)


class Database(DBComponent):
    def __init__(self,dbName) -> None:
        super().__init__()
        self.dbName = dbName
        self.tables = []
    
    def addTable(self,table):
        self.tables.append(table)
    
    def dropTable(self,tableName):
        filtered = []
        for table in self.tables:
            if table["tableName"] != tableName:
                filtered.append(table)
        self.tables = filtered
    
    def accept(self, visitor):
        visitor.visitDB(self)



class CSVGenerator(Visitor):
    def __init__(self) -> None:
        super().__init__();
    
    def visitTable(self, table ):
        with open('users.csv', 'a', newline='') as csvfile:
            writer = csv.writer(csvfile, delimiter=' ',
                                    quotechar='|', quoting=csv.QUOTE_MINIMAL)
            writer.writerow([table.name, table.email, table.avatar])

    def visitDB(self, db):
        print(db.tables[0].__dict__)
        with open('db.csv', 'a', newline='') as csvFile:
            writer = csv.writer(csvFile, delimiter=' ', quotechar="|", quoting=csv.QUOTE_MINIMAL)
            for item in db.tables:
               writer.writerow([item.name, item.email, item.avatar])






def main():

    db = Database('Dunder Mifflin')

    user = User("Fleece","fleece@out", "fleece.png")
    user_2 = User("Dunkin","dunkin@flicka", "dunkin.png")

    db.addTable(user)
    db.addTable(user_2)

    csvGenerator = CSVGenerator()

    user.accept(csvGenerator)
    user_2.accept(csvGenerator)

    db.accept(csvGenerator)

main()

