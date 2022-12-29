package android.example.tng.profile

import android.example.tng.base.BaseRecyclerAdapter

class ProfileAdapter(
    //select: (event: Event) -> Unit = {}
) : BaseRecyclerAdapter(
    listOf(
        UserDelegate(),
    )
)