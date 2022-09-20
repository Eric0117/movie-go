// component
import Iconify from "../../components/Iconify"

import { isLoggedInState } from "../../store/authStore"

// ----------------------------------------------------------------------

const getIcon = (name) => <Iconify icon={name} width={22} height={22} />

const navConfig = [
    {
        title: "홈",
        path: "/",
        icon: getIcon("eva:home-fill"),
    },
    {
        title: "상영중인 영화",
        path: "/dashboard/user",
        icon: getIcon("eva:checkmark-circle-2-fill"),
    },
    {
        title: "개봉예정 영화",
        path: "/dashboard/products",
        icon: getIcon("eva:clock-fill"),
    },
    {
        title: "박스오피스",
        path: "/dashboard/blog",
        icon: getIcon("eva:award-fill"),
    },
    {
        title: "나의 예약",
        path: "/login",
        icon: getIcon("eva:film-outline"),
    },
]

export default navConfig
