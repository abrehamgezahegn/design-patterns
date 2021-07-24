import random

class CarType:
    def __init__(self,name,acc, heavyRamConsumingField) -> None:
        self.name = name 
        self.acceleration  = acc
        self.heavyRamConsumingField = heavyRamConsumingField;

    def moveTo(x,y):
        print("Moving car to: ", x, "and ", y)
    

class Car:
    def __init__(self,car_type,color, x,y) -> None:
        self.car_type = car_type
        self.x = x 
        self.y = y
        self.color = color

    
    def moveTo(self,x,y):
        self.car_type.moveTo(x,y)
    

class CarTypeFactory:

    car_types = {}

    def get_car_type(self, car_type_name,acc,heavyRamConsumingField):
        car_types = CarTypeFactory.car_types
        if car_type_name not in car_types.keys():
            car_type = CarType(car_type_name,acc,heavyRamConsumingField)
            car_types[car_type_name] = car_type
        else:
            car_type = car_types[car_type_name]
        return car_type


class RaceGame:


    def __init__(self) -> None:
        self.cars = []
        self.colors = ["#000", "#f4f4f4", "#5611df"]


    def init_race(self):
        for i in range(1,100):
            if i % 2:
                car_type = CarTypeFactory.get_car_type(CarTypeFactory,"Tesla",  23,"VERY_LARGE_FIELD")
            elif i % 3:
                car_type = CarTypeFactory.get_car_type(CarTypeFactory,"Audi",  14,"VERY_LARGE_FIELD_2")
            elif i % 4:
                car_type = CarTypeFactory.get_car_type(CarTypeFactory, "BMW", 15,"VERY_LARGE_FIELD_3")
            color = self.colors[random.randrange(0,2)]
            car = Car(car_type=car_type,color=color, x=i*32.5 , y=i*43.5)  
            self.cars.append(car)
    
    def render_car(self,number):
        print("Redering " , self.cars[number].__dict__)
        return self.cars[number]


def main():
    race_game = RaceGame()
    race_game.init_race()
    race_game.render_car(4)


main()






    
    






