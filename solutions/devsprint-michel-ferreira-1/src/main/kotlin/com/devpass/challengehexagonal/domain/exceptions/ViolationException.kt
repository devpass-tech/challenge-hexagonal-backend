package com.devpass.challengehexagonal.domain.exceptions

import com.devpass.challengehexagonal.domain.model.Violation

class ViolationException(violations: List<Violation>): Exception(violations)