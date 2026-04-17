from abc import ABC, abstractmethod




# =======Operable

class Operable(ABC):

    @abstractmethod
    def iniciar_operacion(self):
        pass

    @abstractmethod
    def finalizar_operacion(self):
        pass



# =======Clase abstracta=======

class UnidadEntrega(Operable, ABC):

    def __init__(self, id, nombreOperador, capacidadCarga, zonaOperacion):
        self.id = id
        self.nombreOperador = nombreOperador
        self.capacidadCarga = capacidadCarga
        self.zonaOperacion = zonaOperacion

    def mostrar_info(self):
        print(f"\nID: {self.id} \nNombre de vehículo: {self.nombreOperador}")
        print(f"Capacidad de carga: {self.capacidadCarga} kg - Zona: {self.zonaOperacion}\n")

    @abstractmethod
    def realizar_entrega(self):
        pass


 
# ========Bicicleta=======

class Bicicleta(UnidadEntrega):

    def __init__(self, id, nombreOperador, capacidadCarga, zonaOperacion, tiene_canasta, tipoPedaleo):
        super().__init__(id, nombreOperador, capacidadCarga, zonaOperacion)
        self.tiene_canasta = tiene_canasta
        self.tipoPedaleo = tipoPedaleo

    def realizar_entrega(self):
        print("Entrega ecológica en trayecto corto")
    def realizar_entrega(self):
        if self.tipoPedaleo == "Rápido":
            print("Entrega rápida.")
        else:
            print("Entrega lenta.")

    def iniciar_operacion(self):
        print("Bicicleta lista")

    def finalizar_operacion(self):
        print("Bicicleta finalizada")



# =======Motocicleta=======

class Motocicleta(UnidadEntrega):

    def __init__(self, id, nombreOperador, capacidadCarga, zonaOperacion, cilindraje):
        super().__init__(id, nombreOperador, capacidadCarga, zonaOperacion)
        self.cilindraje = cilindraje

    def realizar_entrega(self):
        print("Entrega rápida en zona urbana")

    def iniciar_operacion(self):
        print("Moto prendida")

    def finalizar_operacion(self):
        print("Moto apagada")


# 
# =======Dron============
# 
class Drone(UnidadEntrega):

    def __init__(self, id, nombreOperador, capacidadCarga, zonaOperacion, bateria):
        super().__init__(id, nombreOperador, capacidadCarga, zonaOperacion)
        self.bateria = bateria

    def realizar_entrega(self):
        if self.bateria < 20:
            print("Batería baja, no es posible entregarse")
        else:
            print("Entrega aérea")

    def iniciar_operacion(self):
        print("Dron despegando")

    def finalizar_operacion(self):
        print("Drone aterrizó")


# 
# =========MAIN==========
# 
if __name__ == "__main__":

    unidades = [
        Bicicleta("BIC001", "Bicicleta Fixied", 10, "Centro de Bogotá", True, "Lento"),
        Motocicleta("moto1", "KTM", 20, "Chapinero", 150),
        Drone("DRN001", "Dron DJI", 5, "Tunjuelito", 80)
    ]

    for u in unidades:
        u.mostrar_info()
        u.iniciar_operacion()
        u.realizar_entrega()
        u.finalizar_operacion()