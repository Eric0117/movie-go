// @mui
import { useTheme } from "@mui/material/styles"
import { Grid, Container, Card, Typography } from "@mui/material"

import Page from "../components/Page"
import Iconify from "../components/Iconify"
import { useQuery } from "@tanstack/react-query"
import { getData } from "../api/apiClient"
import { useRecoilValue } from "recoil"
import authState from "../store/authStore"

export default function Main({ color = "secondary" }) {
    const theme = useTheme()
    const user = useRecoilValue(authState)
    const { isLoading, isError, data, error } = useQuery(["test"], () =>
        getData("test/1")
    )

    if (isError) {
        return <span>Error: {error}</span>
    }

    return (
        <Page title="홈">
            <Container maxWidth="xl">
                <Grid container spacing={3}>
                    <Grid item xs={12} sm={6} md={3}>
                        <Card
                            sx={{
                                py: 5,
                                boxShadow: 0,
                                textAlign: "center",
                                bgcolor: (theme) =>
                                    theme.palette[color].lighter,
                            }}
                        >
                            <Typography variant="h4" sx={{ mb: 5 }}>
                                Hi, Welcome back {JSON.stringify(user)}
                            </Typography>
                        </Card>
                    </Grid>
                </Grid>
            </Container>
        </Page>
    )
}
