package com.example.nyc_schools_test.common

import com.example.nyc_schools_test.domain.SchoolDomain
import com.example.nyc_schools_test.model.remote.SchoolListResponse

interface OnSchoolClicked {
    fun schoolClicked(school: SchoolDomain)
}