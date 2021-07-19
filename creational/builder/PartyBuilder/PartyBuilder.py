from abc import ABC, abstractmethod


class Party:
    def __init__(self, theme,date, location ) -> None:
        self.theme = theme
        self.date = date
        self.location = location
        self.size = None
        self.menu = None
        self.drink = None
        self.after_party = None
    
    def get_theme(self):
        return self.theme
    
    def get_date(self):
        return self.date
    
    def set_date(self, date):
        self.date = date
        return self.date



class Builder(ABC):
    def __init__(self) -> None:
        pass

    @abstractmethod
    def set_size(self,size):
        pass
    
    @abstractmethod
    def set_menu(self,menu):
        pass

    @abstractmethod
    def set_drink(self,drink):
        pass
   
    @abstractmethod
    def set_after_party(self,after_party):
        pass


# Different branches (builders i.e Dunder,Nashua...) 
# has their own way of building a party (different way of implementing 
# the builder methods)
class DunderPartyBuilder(Builder):
    def __init__(self,theme,date,location) -> None:
        super().__init__()
        self.party = Party(theme,date,location)
        
        # for reset method
        self.theme = theme
        self.date = date
        self.location = location
        pass


    def reset(self):
        self.party = Party(self.theme,self.date,self.location)


    def set_size(self,size):
        self.party.size = size
        
    
    def set_menu(self,menu):
        self.party.menu = menu


    def set_drink(self,drink):
        self.party.drink = drink
   

    def set_after_party(self,after_party):
        print("Calling the club")
        print("Booking seats")
        self.party.after_party = after_party
    
    def get_party(self):
        # self.reset();
        return self.party


class NashuaPartyBuilder(Builder):
    def __init__(self,theme,date,location) -> None:
        super().__init__()
        self.party = Party(theme,date,location)
        
        # for reset method
        self.theme = theme
        self.date = date
        self.location = location
        pass


    def reset(self):
        self.party = Party(self.theme,self.date,self.location)


    def set_size(self,size):
        print("Check budget with account")
        self.party.size = size
        
    
    def set_menu(self,menu):
        self.party.menu = menu


    def set_drink(self,drink):
        print("Check drink amount and quality")
        self.party.drink = drink
   

    def set_after_party(self,after_party):
        print("Order a limousine")
        print("Check dress code")
        self.set_drink("Wine based")
        self.party.after_party = after_party
    
    def get_party(self):
        # self.reset();
        return self.party






class PartyPlanningCommittee():
    def __init__(self) -> None:
        pass
        self.builder = None
    
    
    def set_builder(self,builder):
        self.builder = builder
    
    
    def throw_the_office_party(self,builder):
        self.builder = builder
        builder.set_size(14)
        builder.set_menu("Mexican")
        builder.set_drink("Non alcohol")

    
    def throw_birthday_party(self,builder):
        self.builder = builder
        builder.set_menu("Desserts")
        builder.set_size(200)
        builder.set_after_party("Yes")
        builder.set_drink("Soda only")





def main():
    # director
    ppc = PartyPlanningCommittee()
   

    dm_party_builder = DunderPartyBuilder("Halloween", "Tue, 12 July", "Scranton, Penny")
    ppc.throw_the_office_party(dm_party_builder)
    party = dm_party_builder.get_party()
    print("Dunder Party: ", party.__dict__)

    nasuha_party_builder = NashuaPartyBuilder("Christmas", "Fri, Jan 01" , "New Hampshire")
    ppc.throw_the_office_party(nasuha_party_builder)
    print("Nasua party: " , party.__dict__)










main()