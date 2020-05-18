package ru.serg.testnauka.errors

import java.util.*

class NotFoundException(o: Any) : RuntimeException("Could not find employee $o")