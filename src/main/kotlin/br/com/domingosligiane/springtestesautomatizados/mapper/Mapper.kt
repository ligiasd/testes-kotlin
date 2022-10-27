package br.com.domingosligiane.springtestesautomatizados.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}