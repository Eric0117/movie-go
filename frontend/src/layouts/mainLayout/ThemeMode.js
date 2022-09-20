import { useState, useEffect } from "react"
import { useTheme } from "@mui/material/styles"
import Iconify from "../../components/Iconify"
import { IconButton } from "@mui/material"
export default function ThemeMode() {
    const theme = useTheme()
    const [themeMode, setThemeMode] = useState("light")

    useEffect(() => {
        if (themeMode === "light") {
            theme.palette.mode = "dark"
        } else {
            theme.palette.mode = "light"
        }
        console.log(theme.palette.mode)
    }, [themeMode])

    const handleChange = () => {
        setThemeMode(themeMode === "light" ? "dark" : "light")
    }

    return (
        <>
            <IconButton
                onClick={handleChange}
                color={"primary"}
                sx={{ width: 40, height: 40 }}
            >
                {themeMode == "light" ? (
                    <Iconify icon="eva:moon-fill" width={20} height={20} />
                ) : (
                    <Iconify icon="eva:sun-fill" width={20} height={20} />
                )}
            </IconButton>
        </>
    )
}
