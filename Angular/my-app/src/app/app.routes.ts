import { Routes } from '@angular/router';
import { AboutComponent } from './pages/about/about.component';
import { PortfolioComponent } from './pages/portfolio/portfolio.component';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';

export const routes: Routes = [
    {path: 'about', component: AboutComponent},
    {path: 'portfolio', component: PortfolioComponent},
    {path: '**', component: PageNotFoundComponent},
    {path: '', redirectTo: 'portfolio', pathMatch: 'full'},
];
