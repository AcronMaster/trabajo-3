class Ventas:
    def __init__(self):
        
        self.ventas = [
            [0] * 12,  
            [0] * 12, 
            [0] * 12   
        ]
        self.departamentos = ['ropa', 'deportes', 'juguetería']

    def insertar_ventas(self, departamento, mes, monto):
        """
        Inserta las ventas de un departamento en un mes específico.
        :param departamento: Nombre del departamento ('ropa', 'deportes', 'juguetería').
        :param mes: Mes en el que se realiza la venta (1 a 12).
        :param monto: Monto de la venta a insertar.
        """
        if departamento in self.departamentos and 1 <= mes <= 12:
            index = self.departamentos.index(departamento)
            self.ventas[index][mes - 1] = monto
            print(f"Venta de {monto} insertada para {departamento} en el mes {mes}.")
        else:
            print("Departamento o mes inválido.")

    def buscar_venta(self, departamento, mes):
        """
        Busca y retorna las ventas de un departamento en un mes específico.
        :param departamento: Nombre del departamento ('ropa', 'deportes', 'juguetería').
        :param mes: Mes a buscar (1 a 12).
        :return: Monto de las ventas del departamento en el mes especificado.
        """
        if departamento in self.departamentos and 1 <= mes <= 12:
            index = self.departamentos.index(departamento)
            monto = self.ventas[index][mes - 1]
            print(f"Venta en {departamento} durante el mes {mes}: {monto}.")
            return monto
        else:
            print("Departamento o mes inválido.")
            return None

    def eliminar_ventas(self, departamento):
        """
        Elimina todas las ventas de un departamento.
        :param departamento: Nombre del departamento ('ropa', 'deportes', 'juguetería').
        """
        if departamento in self.departamentos:
            index = self.departamentos.index(departamento)
            self.ventas[index] = [0] * 12
            print(f"Ventas eliminadas para el departamento {departamento}.")
        else:
            print("Departamento inválido.")

    def pedir_datos(self):
        """
        Solicita al usuario que ingrese las ventas para cada departamento y mes.
        """
        for i in range(3):  # Recorre los 3 departamentos
            print(f"\nIngrese las ventas para el departamento de {self.departamentos[i]}:")
            for j in range(12):  # Recorre los 12 meses
                while True:
                    try:
                        monto = float(input(f"  Mes {j + 1}: "))
                        if monto < 0:
                            raise ValueError("El monto no puede ser negativo.")
                        self.insertar_ventas(self.departamentos[i], j + 1, monto)
                        break
                    except ValueError as e:
                        print(f"Entrada inválida. {e} Inténtelo nuevamente.")

    def mostrar_ventas(self):
        """
        Muestra el arreglo completo de ventas por departamento y mes.
        """
        print("\nVentas del año por departamento:")
        for i, departamento in enumerate(self.departamentos):
            print(f"{departamento.capitalize()}: {self.ventas[i]}")


ventas = Ventas()


ventas.pedir_datos()


ventas.mostrar_ventas()


departamento = input("\nIngrese el nombre del departamento para buscar ventas ('ropa', 'deportes', 'juguetería'): ").strip()
mes = int(input("Ingrese el mes para buscar ventas (1 a 12): ").strip())
ventas.buscar_venta(departamento, mes)


departamento_a_eliminar = input("\nIngrese el nombre del departamento para eliminar ventas ('ropa', 'deportes', 'juguetería'): ").strip()
ventas.eliminar_ventas(departamento_a_eliminar)


ventas.mostrar_ventas()