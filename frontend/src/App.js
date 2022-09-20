import React, { Suspense } from "react"

// routes
import Router from "./routes"

// recoil
import {
    RecoilRoot,
    atom,
    selector,
    useRecoilState,
    useRecoilValue,
} from "recoil"

import ThemeProvider from "./theme"
import ScrollToTop from "./components/ScrollToTop"

import Spinner from "./components/Spinner"

import {
    useQuery,
    useMutation,
    useQueryClient,
    QueryClient,
    QueryClientProvider,
} from "@tanstack/react-query"

const queryClient = new QueryClient({
    defaultOptions: {
        queries: {
            suspense: true,
            refetchOnWindowFocus: false,
            retry: 0,
        },
    },
})
function App() {
    return (
        <RecoilRoot>
            <QueryClientProvider client={queryClient}>
                <ThemeProvider>
                    <ScrollToTop />
                    <Router />
                </ThemeProvider>
            </QueryClientProvider>
        </RecoilRoot>
    )
}

export default App
