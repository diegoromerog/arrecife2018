export class RegistroUsuario {

    constructor(
        public idusuario?: number,
        public correoElectronico?: string,
        public nombres?: string,
        public telefonoCelular?: string,
        public telefonoFijo?: string,
        public empresa?: string,
        public cargo?: string,
        public basesDeDatos?: string,
        public servidorAplicaciones?: string,
        public estado?: string,
        public comentariosEstado?: string
    ) {

    }
}