import { atom, selector, useRecoilState, useRecoilValue } from "recoil"

const authState = atom({
    key: "authState",
    // get initial state from local storage to enable user to stay logged in
    //default: JSON.parse(localStorage.getItem("user")),
    default: null,
})

export const isLoggedInState = atom({
    key: "isLoggedInState",
    default: false,
})

export default authState
