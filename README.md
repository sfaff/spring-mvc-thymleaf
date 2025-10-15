import React from 'react';
import { BrowserRouter as Router, Routes, Route, useNavigate } from 'react-router-dom';
import { MegaMenu } from 'primereact/megamenu';
import { MenuItem } from 'primereact/menuitem';
import 'primereact/resources/themes/lara-light-blue/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';

// Types
interface PageContentProps {
  category: string;
  subcategory: string;
  item: string;
}

interface MenuItemWithLabel extends MenuItem {
  label: string;
}

// Page Component
const PageContent: React.FC<PageContentProps> = ({ category, subcategory, item }) => {
  return (
    <div style={{ padding: '2rem', marginTop: '1rem' }}>
      <h1 style={{ fontSize: '2rem', fontWeight: 'bold', marginBottom: '1rem', color: '#1e293b' }}>
        {item}
      </h1>
      <p style={{ color: '#64748b', fontSize: '1.1rem', marginBottom: '1rem' }}>
        Category: {category} / {subcategory}
      </p>
      <div style={{ 
        marginTop: '2rem', 
        padding: '1.5rem', 
        background: 'white', 
        borderRadius: '8px', 
        boxShadow: '0 1px 3px rgba(0,0,0,0.1)' 
      }}>
        <p>Welcome to the {item} page.</p>
        <p style={{ marginTop: '1rem', color: '#64748b' }}>
          This page demonstrates PrimeReact MegaMenu integration with React Router and TypeScript.
        </p>
      </div>
    </div>
  );
};

// MegaMenu Component
const MegaMenuComponent: React.FC = () => {
  const navigate = useNavigate();

  // Helper function to create route path
  const createPath = (category: string, subcategory: string, item: string): string => {
    const slugify = (text: string): string => text.toLowerCase().replace(/\s+/g, '-');
    return `/${slugify(category)}/${slugify(subcategory)}/${slugify(item)}`;
  };

  // Helper function to add command to items with custom paths
  const addCommandToItems = (items: (MenuItemWithLabel & { path?: string })[]): MenuItem[] => {
    return items.map(item => ({
      ...item,
      command: () => {
        // Use custom path if provided, otherwise skip navigation
        if (item.path) {
          navigate(item.path);
        }
      }
    }));
  };

  const items: MenuItem[] = [
    {
      label: 'Furniture',
      icon: 'pi pi-box',
      items: [
        [
          {
            label: 'Living Room',
            items: addCommandToItems([
              { label: 'Accessories', path: '/furniture/living-room/accessories' },
              { label: 'Armchair', path: '/furniture/living-room/armchair' },
              { label: 'Coffee Table', path: '/furniture/living-room/coffee-table' },
              { label: 'Couch', path: '/furniture/living-room/couch' },
              { label: 'TV Stand', path: '/furniture/living-room/tv-stand' }
            ])
          }
        ],
        [
          {
            label: 'Kitchen',
            items: addCommandToItems([
              { label: 'Bar stool', path: '/furniture/kitchen/bar-stool' },
              { label: 'Chair', path: '/furniture/kitchen/chair' },
              { label: 'Table', path: '/furniture/kitchen/table' }
            ])
          },
          {
            label: 'Bathroom',
            items: addCommandToItems([
              { label: 'Accessories', path: '/furniture/bathroom/accessories' }
            ])
          }
        ],
        [
          {
            label: 'Bedroom',
            items: addCommandToItems([
              { label: 'Bed', path: '/furniture/bedroom/bed' },
              { label: 'Chaise lounge', path: '/furniture/bedroom/chaise-lounge' },
              { label: 'Cupboard', path: '/furniture/bedroom/cupboard' },
              { label: 'Dresser', path: '/furniture/bedroom/dresser' },
              { label: 'Wardrobe', path: '/furniture/bedroom/wardrobe' }
            ])
          }
        ],
        [
          {
            label: 'Office',
            items: addCommandToItems([
              { label: 'Bookcase', path: '/furniture/office/bookcase' },
              { label: 'Cabinet', path: '/furniture/office/cabinet' },
              { label: 'Chair', path: '/furniture/office/chair' },
              { label: 'Desk', path: '/furniture/office/desk' },
              { label: 'Executive Chair', path: '/furniture/office/executive-chair' }
            ])
          }
        ]
      ]
    },
    {
      label: 'Electronics',
      icon: 'pi pi-mobile',
      items: [
        [
          {
            label: 'Computer',
            items: addCommandToItems([
              { label: 'Monitor', path: '/electronics/computer/monitor' },
              { label: 'Mouse', path: '/electronics/computer/mouse' },
              { label: 'Notebook', path: '/electronics/computer/notebook' },
              { label: 'Keyboard', path: '/electronics/computer/keyboard' },
              { label: 'Printer', path: '/electronics/computer/printer' },
              { label: 'Storage', path: '/electronics/computer/storage' }
            ])
          }
        ],
        [
          {
            label: 'Home Theather',
            items: addCommandToItems([
              { label: 'Projector', path: '/electronics/home-theather/projector' },
              { label: 'Speakers', path: '/electronics/home-theather/speakers' },
              { label: 'TVs', path: '/electronics/home-theather/tvs' }
            ])
          }
        ],
        [
          {
            label: 'Gaming',
            items: addCommandToItems([
              { label: 'Accessories', path: '/electronics/gaming/accessories' },
              { label: 'Console', path: '/electronics/gaming/console' },
              { label: 'PC', path: '/electronics/gaming/pc' },
              { label: 'Video Games', path: '/electronics/gaming/video-games' }
            ])
          }
        ],
        [
          {
            label: 'Appliances',
            items: addCommandToItems([
              { label: 'Coffee Machine', path: '/electronics/appliances/coffee-machine' },
              { label: 'Fridge', path: '/electronics/appliances/fridge' },
              { label: 'Oven', path: '/electronics/appliances/oven' },
              { label: 'Vaccum Cleaner', path: '/electronics/appliances/vaccum-cleaner' },
              { label: 'Washing Machine', path: '/electronics/appliances/washing-machine' }
            ])
          }
        ]
      ]
    },
    {
      label: 'Sports',
      icon: 'pi pi-clock',
      items: [
        [
          {
            label: 'Football',
            items: addCommandToItems([
              { label: 'Kits', path: '/sports/football/kits' },
              { label: 'Shoes', path: '/sports/football/shoes' },
              { label: 'Shorts', path: '/sports/football/shorts' },
              { label: 'Training', path: '/sports/football/training' }
            ])
          }
        ],
        [
          {
            label: 'Running',
            items: addCommandToItems([
              { label: 'Accessories', path: '/sports/running/accessories' },
              { label: 'Shoes', path: '/sports/running/shoes' },
              { label: 'T-Shirts', path: '/sports/running/t-shirts' },
              { label: 'Shorts', path: '/sports/running/shorts' }
            ])
          }
        ],
        [
          {
            label: 'Swimming',
            items: addCommandToItems([
              { label: 'Kickboard', path: '/sports/swimming/kickboard' },
              { label: 'Nose Clip', path: '/sports/swimming/nose-clip' },
              { label: 'Swimsuits', path: '/sports/swimming/swimsuits' },
              { label: 'Paddles', path: '/sports/swimming/paddles' }
            ])
          }
        ],
        [
          {
            label: 'Tennis',
            items: addCommandToItems([
              { label: 'Balls', path: '/sports/tennis/balls' },
              { label: 'Rackets', path: '/sports/tennis/rackets' },
              { label: 'Shoes', path: '/sports/tennis/shoes' },
              { label: 'Training', path: '/sports/tennis/training' }
            ])
          }
        ]
      ]
    }
  ];

  return (
    <div className="card" style={{ position: 'fixed', top: 0, left: 0, right: 0, zIndex: 1000, background: 'white' }}>
      <MegaMenu model={items} breakpoint="960px" />
    </div>
  );
};

// Home Page
const HomePage: React.FC = () => {
  return (
    <div style={{ padding: '2rem', marginTop: '80px' }}>
      <h1 style={{ fontSize: '2.5rem', fontWeight: 'bold', marginBottom: '1rem', color: '#1e293b' }}>
        Welcome to Our Store
      </h1>
      <p style={{ color: '#64748b', fontSize: '1.2rem' }}>
        Browse our collection using the menu above.
      </p>
      <div style={{ 
        marginTop: '2rem', 
        padding: '2rem', 
        background: 'white', 
        borderRadius: '8px', 
        boxShadow: '0 1px 3px rgba(0,0,0,0.1)' 
      }}>
        <h2 style={{ fontSize: '1.5rem', marginBottom: '1rem', color: '#1e293b' }}>Featured Categories</h2>
        <ul style={{ listStyle: 'none', padding: 0 }}>
          <li style={{ marginBottom: '0.5rem', color: '#64748b' }}>🛋️ Furniture - Living Room, Kitchen, Bedroom, Office</li>
          <li style={{ marginBottom: '0.5rem', color: '#64748b' }}>📱 Electronics - Computers, Gaming, Home Theater, Appliances</li>
          <li style={{ marginBottom: '0.5rem', color: '#64748b' }}>⚽ Sports - Football, Running, Swimming, Tennis</li>
        </ul>
      </div>
    </div>
  );
};

// Main App Component
const App: React.FC = () => {
  return (
    <Router>
      <div style={{ minHeight: '100vh', background: '#f8f9fa' }}>
        <MegaMenuComponent />
        <div style={{ marginTop: '60px' }}>
          <Routes>
            <Route path="/" element={<HomePage />} />
            
            {/* Furniture Routes */}
            <Route path="/furniture/living-room/accessories" element={<PageContent category="Furniture" subcategory="Living Room" item="Accessories" />} />
            <Route path="/furniture/living-room/armchair" element={<PageContent category="Furniture" subcategory="Living Room" item="Armchair" />} />
            <Route path="/furniture/living-room/coffee-table" element={<PageContent category="Furniture" subcategory="Living Room" item="Coffee Table" />} />
            <Route path="/furniture/living-room/couch" element={<PageContent category="Furniture" subcategory="Living Room" item="Couch" />} />
            <Route path="/furniture/living-room/tv-stand" element={<PageContent category="Furniture" subcategory="Living Room" item="TV Stand" />} />
            
            <Route path="/furniture/kitchen/bar-stool" element={<PageContent category="Furniture" subcategory="Kitchen" item="Bar stool" />} />
            <Route path="/furniture/kitchen/chair" element={<PageContent category="Furniture" subcategory="Kitchen" item="Chair" />} />
            <Route path="/furniture/kitchen/table" element={<PageContent category="Furniture" subcategory="Kitchen" item="Table" />} />
            
            <Route path="/furniture/bathroom/accessories" element={<PageContent category="Furniture" subcategory="Bathroom" item="Accessories" />} />
            
            <Route path="/furniture/bedroom/bed" element={<PageContent category="Furniture" subcategory="Bedroom" item="Bed" />} />
            <Route path="/furniture/bedroom/chaise-lounge" element={<PageContent category="Furniture" subcategory="Bedroom" item="Chaise lounge" />} />
            <Route path="/furniture/bedroom/cupboard" element={<PageContent category="Furniture" subcategory="Bedroom" item="Cupboard" />} />
            <Route path="/furniture/bedroom/dresser" element={<PageContent category="Furniture" subcategory="Bedroom" item="Dresser" />} />
            <Route path="/furniture/bedroom/wardrobe" element={<PageContent category="Furniture" subcategory="Bedroom" item="Wardrobe" />} />
            
            <Route path="/furniture/office/bookcase" element={<PageContent category="Furniture" subcategory="Office" item="Bookcase" />} />
            <Route path="/furniture/office/cabinet" element={<PageContent category="Furniture" subcategory="Office" item="Cabinet" />} />
            <Route path="/furniture/office/chair" element={<PageContent category="Furniture" subcategory="Office" item="Chair" />} />
            <Route path="/furniture/office/desk" element={<PageContent category="Furniture" subcategory="Office" item="Desk" />} />
            <Route path="/furniture/office/executive-chair" element={<PageContent category="Furniture" subcategory="Office" item="Executive Chair" />} />
            
            {/* Electronics Routes */}
            <Route path="/electronics/computer/monitor" element={<PageContent category="Electronics" subcategory="Computer" item="Monitor" />} />
            <Route path="/electronics/computer/mouse" element={<PageContent category="Electronics" subcategory="Computer" item="Mouse" />} />
            <Route path="/electronics/computer/notebook" element={<PageContent category="Electronics" subcategory="Computer" item="Notebook" />} />
            <Route path="/electronics/computer/keyboard" element={<PageContent category="Electronics" subcategory="Computer" item="Keyboard" />} />
            <Route path="/electronics/computer/printer" element={<PageContent category="Electronics" subcategory="Computer" item="Printer" />} />
            <Route path="/electronics/computer/storage" element={<PageContent category="Electronics" subcategory="Computer" item="Storage" />} />
            
            <Route path="/electronics/home-theather/projector" element={<PageContent category="Electronics" subcategory="Home Theather" item="Projector" />} />
            <Route path="/electronics/home-theather/speakers" element={<PageContent category="Electronics" subcategory="Home Theather" item="Speakers" />} />
            <Route path="/electronics/home-theather/tvs" element={<PageContent category="Electronics" subcategory="Home Theather" item="TVs" />} />
            
            <Route path="/electronics/gaming/accessories" element={<PageContent category="Electronics" subcategory="Gaming" item="Accessories" />} />
            <Route path="/electronics/gaming/console" element={<PageContent category="Electronics" subcategory="Gaming" item="Console" />} />
            <Route path="/electronics/gaming/pc" element={<PageContent category="Electronics" subcategory="Gaming" item="PC" />} />
            <Route path="/electronics/gaming/video-games" element={<PageContent category="Electronics" subcategory="Gaming" item="Video Games" />} />
            
            <Route path="/electronics/appliances/coffee-machine" element={<PageContent category="Electronics" subcategory="Appliances" item="Coffee Machine" />} />
            <Route path="/electronics/appliances/fridge" element={<PageContent category="Electronics" subcategory="Appliances" item="Fridge" />} />
            <Route path="/electronics/appliances/oven" element={<PageContent category="Electronics" subcategory="Appliances" item="Oven" />} />
            <Route path="/electronics/appliances/vaccum-cleaner" element={<PageContent category="Electronics" subcategory="Appliances" item="Vaccum Cleaner" />} />
            <Route path="/electronics/appliances/washing-machine" element={<PageContent category="Electronics" subcategory="Appliances" item="Washing Machine" />} />
            
            {/* Sports Routes */}
            <Route path="/sports/football/kits" element={<PageContent category="Sports" subcategory="Football" item="Kits" />} />
            <Route path="/sports/football/shoes" element={<PageContent category="Sports" subcategory="Football" item="Shoes" />} />
            <Route path="/sports/football/shorts" element={<PageContent category="Sports" subcategory="Football" item="Shorts" />} />
            <Route path="/sports/football/training" element={<PageContent category="Sports" subcategory="Football" item="Training" />} />
            
            <Route path="/sports/running/accessories" element={<PageContent category="Sports" subcategory="Running" item="Accessories" />} />
            <Route path="/sports/running/shoes" element={<PageContent category="Sports" subcategory="Running" item="Shoes" />} />
            <Route path="/sports/running/t-shirts" element={<PageContent category="Sports" subcategory="Running" item="T-Shirts" />} />
            <Route path="/sports/running/shorts" element={<PageContent category="Sports" subcategory="Running" item="Shorts" />} />
            
            <Route path="/sports/swimming/kickboard" element={<PageContent category="Sports" subcategory="Swimming" item="Kickboard" />} />
            <Route path="/sports/swimming/nose-clip" element={<PageContent category="Sports" subcategory="Swimming" item="Nose Clip" />} />
            <Route path="/sports/swimming/swimsuits" element={<PageContent category="Sports" subcategory="Swimming" item="Swimsuits" />} />
            <Route path="/sports/swimming/paddles" element={<PageContent category="Sports" subcategory="Swimming" item="Paddles" />} />
            
            <Route path="/sports/tennis/balls" element={<PageContent category="Sports" subcategory="Tennis" item="Balls" />} />
            <Route path="/sports/tennis/rackets" element={<PageContent category="Sports" subcategory="Tennis" item="Rackets" />} />
            <Route path="/sports/tennis/shoes" element={<PageContent category="Sports" subcategory="Tennis" item="Shoes" />} />
            <Route path="/sports/tennis/training" element={<PageContent category="Sports" subcategory="Tennis" item="Training" />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
};

export default App;
