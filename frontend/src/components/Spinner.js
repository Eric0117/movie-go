import React from "react"
import { Box, Fade, CircularProgress } from "@mui/material/"
import { styled } from "@mui/material/styles"

const DivWrapper = styled("div")(({ theme }) => ({
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    zIndex: 9999,
}))

const Spinner = (props) => {
    return (
        <DivWrapper>
            <Fade in={true}>
                <Box
                    sx={{
                        display: "flex",
                        alignContent: "center",
                        alignItems: "center",
                        verticalAlign: "middle",
                        backgroundColor: "transparent",
                    }}
                >
                    <CircularProgress color="primary" />
                </Box>
            </Fade>
        </DivWrapper>
    )
}

export default Spinner
